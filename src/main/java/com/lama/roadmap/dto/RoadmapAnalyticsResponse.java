package com.lama.roadmap.dto;

import java.util.Map;

public class RoadmapAnalyticsResponse {
	private long totalRoadmaps;
	private long roadmapsToday;
	private long roadmapsThisWeek;

	
	public RoadmapAnalyticsResponse(
	        long totalRoadmaps,
	        long roadmapsToday,
	        long roadmapsThisWeek,
	        Map<String, Long> popularPaths) {

	    this.totalRoadmaps = totalRoadmaps;
	    this.roadmapsToday = roadmapsToday;
	    this.roadmapsThisWeek = roadmapsThisWeek;
	    this.popularPaths = popularPaths;
	}
	public long getTotalRoadmaps() {
		return totalRoadmaps;
	}

	public void setTotalRoadmaps(long totalRoadmaps) {
		this.totalRoadmaps = totalRoadmaps;
	}

	public long getRoadmapsToday() {
		return roadmapsToday;
	}

	public void setRoadmapsToday(long roadmapsToday) {
		this.roadmapsToday = roadmapsToday;
	}

	public long getRoadmapsThisWeek() {
		return roadmapsThisWeek;
	}

	public void setRoadmapsThisWeek(long roadmapsThisWeek) {
		this.roadmapsThisWeek = roadmapsThisWeek;
	}

	public Map<String, Long> getPopularPaths() {
		return popularPaths;
	}

	public void setPopularPaths(Map<String, Long> popularPaths) {
		this.popularPaths = popularPaths;
	}

	private Map<String, Long> popularPaths;
}
