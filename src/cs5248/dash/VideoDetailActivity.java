package cs5248.dash;

import cs5248.dash.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class VideoDetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_detail);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			int video_id = getIntent().getIntExtra(VideoDetailFragment.ARG_ITEM_ID, -1);
			arguments.putInt(VideoDetailFragment.ARG_ITEM_ID, video_id);
			VideoDetailFragment fragment = new VideoDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().add(R.id.video_detail_container, fragment).commit();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpTo(this, new Intent(this, VideoListActivity.class));
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
