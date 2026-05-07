package com.lama.roadmap.service;

import com.lama.roadmap.model.Resource;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {

	
    private static final String FILE_NAME = "resources_clean.xlsx";

    // =========================
    // LOAD ALL RESOURCES FROM EXCEL (FROM resources FOLDER)
    // =========================
    public List<Resource> loadResources() {

        List<Resource> resources = new ArrayList<>();

        try (
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream(FILE_NAME);

            Workbook workbook = WorkbookFactory.create(is)
        ) {

            if (is == null) {
                throw new RuntimeException("❌ Excel file not found in resources folder");
            }

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue;

                String path = getCellValue(row.getCell(0));
                String topic = getCellValue(row.getCell(1));
                String stepName = getCellValue(row.getCell(2));
                String resourceName = getCellValue(row.getCell(3));
                String link = getCellValue(row.getCell(4));
                String type = getCellValue(row.getCell(5));

                // تجاهل الصفوف الفاضية
                if (path.isBlank() || link.isBlank()) continue;

             // ❌ تجاهل روابط Google Search
             if (link.contains("google.com")) continue;

             // ❌ تجاهل روابط مش https
             if (!link.startsWith("https://")) continue;
             if (!link.contains(".")) continue;
             if (link.contains("google.com") || link.contains("search?q=")) continue;

             resources.add(new Resource(
                        path,
                        topic,
                        stepName,
                        resourceName,
                        link,
                        type
                ));
            }

        } catch (Exception e) {
            System.out.println("❌ Error reading Excel file: " + e.getMessage());
        }

        return resources;
    }

    // =========================
    // FILTER RESOURCES BY PATH (SMART MATCH 🔥)
    // =========================
 // =========================
 // FILTER RESOURCES BY PATH (SMART MATCH 🔥)
 // =========================
    public List<Resource> getResourcesByPath(String learningPath) {
        List<Resource> all = loadResources();
        List<Resource> filtered = new ArrayList<>();

        // استخرجي الكلمة الأولى بس
        String keyword = learningPath.split(" ")[0].toLowerCase(); // "python"

        for (Resource r : all) {
            if (r.getPath() != null &&
                r.getPath().toLowerCase().contains(keyword)) {
                filtered.add(r);
            }
        }
        return filtered;
    }
        

    // =========================
    // RETURN AS TEXT (FOR AI PROMPT)
    // =========================
    public String getResourcesAsText(String learningPath) {
        List<Resource> resources = getResourcesByPath(learningPath);
        
        StringBuilder sb = new StringBuilder();
        // بدون CONTEXT هون
        
        for (Resource r : resources) {
            sb.append("[RESOURCE]\n");
            sb.append("Step Name: ").append(r.getStepName()).append("\n");
            sb.append("Topic: ").append(r.getTopic()).append("\n");
            sb.append("Title: ").append(r.getResourceName()).append("\n");
            sb.append("URL: ").append(r.getLink()).append("\n\n");
        }
        
        return sb.toString();
    }
    // =========================
    // HELPER: SAFE CELL VALUE
    // =========================
    private String getCellValue(Cell cell) {

        if (cell == null) return "";

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }
}