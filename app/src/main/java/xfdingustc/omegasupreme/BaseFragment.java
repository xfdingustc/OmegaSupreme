package xfdingustc.omegasupreme;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2016/5/24.
 */
public class BaseFragment extends Fragment {
    protected View mRootView;

    @NonNull
    protected View createFragmentView(LayoutInflater inflater, ViewGroup container, @LayoutRes int layoutResId,
                                      Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(layoutResId, container, false);

        }
        ButterKnife.bind(this, mRootView);

        return mRootView;
    }
}
