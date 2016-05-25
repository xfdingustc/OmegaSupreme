package xfdingustc.omegasupreme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xfdingustc.omegasupreme.app.OmegaSupreme;

/**
 * Created by Xiaofei on 2016/5/24.
 */
public class FunctionCategory implements Serializable {
    String categoryName;

    ArrayList<FunctionEntry> entries = new ArrayList<>();


    public static List<FunctionCategory> getCategories() {
        List<FunctionCategory> functionCategoryList = new ArrayList<>();

        FunctionCategory category = new FunctionCategory();
        category.categoryName = "UI";
        category.entries.add(new FunctionEntry("Android Support Design Library", R.drawable.android_default, R.string.android_support_design_library));

        functionCategoryList.add(category);
        return functionCategoryList;
    }

}
