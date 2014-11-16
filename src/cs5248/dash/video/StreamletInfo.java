package cs5248.dash.video;

import android.util.SparseArray;

public class StreamletInfo {

	public StreamletInfo() {
		this.cacheFilePath = "";
		this.sourceURLs = new SparseArray<String>(3);
	}
	
	public void setCacheInfo(int quality, String cacheFilePath) {
		this.cacheQuality = quality;
		this.cacheFilePath = cacheFilePath;
	}
	
	public String getCacheFilePath() {
		return this.cacheFilePath;
	}
	
	public int getCacheQuality() {
		return this.cacheQuality;
	}
	
	public String getURLForQuality(int quality) {
		return this.sourceURLs.get(quality);
	}
	
	public void setURLForQuality(int quality, String url) { 
		this.sourceURLs.put(quality, url);
	}
	
	private int cacheQuality;
	private String cacheFilePath;
	private SparseArray<String> sourceURLs;
	
}
