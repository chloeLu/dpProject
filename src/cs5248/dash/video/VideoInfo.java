package cs5248.dash.video;

import java.util.ArrayList;
import java.util.List;

import cs5248.dash.streamer.DashResult;
import cs5248.dash.streamer.DashStreamer;

import android.util.Log;
import android.util.SparseArray;

public class VideoInfo {
	public static class VideoInfoItem {

		public int id;
		public String title;

		public VideoInfoItem(int id, String title) {
			this.id = id;
			this.title = title;
		}

		@Override
		public String toString() {
			return title;
		}
	}

	public static interface UpdateVideoListCallback {
		public void updateVideoListDidFinish(int result, List<VideoInfoItem> videoInfos);
	}

	public static List<VideoInfoItem> ITEMS = new ArrayList<VideoInfoItem>();
	public static SparseArray<VideoInfoItem> ITEM_MAP = new SparseArray<VideoInfoItem>(32);

	private static void addItem(VideoInfoItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	public static void updateVideoList(final UpdateVideoListCallback callback) {
		Log.d("VideoInfo", "Fetching video list from server...");
		DashStreamer.INSTANCE.getVideoList(new DashStreamer.GetVideoListCallback() {

			@Override
			public void getVideoListDidFinish(int result, List<VideoInfoItem> videoInfos) {
				Log.d("VideoInfo", "Get video list finished, result=" + result);

				if (result != DashResult.OK)
					return;

				ITEMS.clear();
				ITEM_MAP.clear();

				for (VideoInfoItem item : videoInfos) {
					Log.v("VideoInfo", "id=" + item.id + " title=" + item.title);
					addItem(item);
				}

				if (callback != null) {
					callback.updateVideoListDidFinish(result, videoInfos);
				}
			}
		});
	}
}
