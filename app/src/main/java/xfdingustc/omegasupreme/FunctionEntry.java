package xfdingustc.omegasupreme;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import java.io.Serializable;

/**
 * Created by Xiaofei on 2016/5/24.
 */
public class FunctionEntry implements Serializable {
    public FunctionEntry(String name, @DrawableRes int res, @StringRes int description) {
        this.entryName = name;
        this.drawRes = res;
        this.description = description;
    }

    String entryName;

    @DrawableRes
    int drawRes;

    @StringRes
    int description;
}
