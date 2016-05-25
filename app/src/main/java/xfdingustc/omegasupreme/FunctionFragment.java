package xfdingustc.omegasupreme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2016/5/24.
 */
public class FunctionFragment extends BaseFragment {

    private FunctionCategory mCategory;

    public static FunctionFragment newInstance(FunctionCategory category) {
        FunctionFragment fragment = new FunctionFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("category", category);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.function_entry_list)
    RecyclerView funtionEntryList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        Bundle bundle = getArguments();
        mCategory = (FunctionCategory)bundle.getSerializable("category");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  createFragmentView(inflater, container, R.layout.fragment_function, savedInstanceState);
        initViews();
        return view;
    }

    private void initViews() {
        funtionEntryList.setLayoutManager(new LinearLayoutManager(getActivity()));
        FunctionEntryAdapter adapter = new FunctionEntryAdapter();
        funtionEntryList.setAdapter(adapter);
    }

    private class FunctionEntryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.item_function_entry, parent, false);
            return new FunctionEntryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            final FunctionEntry functionEntry = mCategory.entries.get(position);
            FunctionEntryViewHolder viewHolder = (FunctionEntryViewHolder)holder;
            viewHolder.tvFuntionCover.setImageResource(functionEntry.drawRes);
            viewHolder.tvFuntionTitle.setText(functionEntry.entryName);
            viewHolder.tvFuntionDescription.setText(functionEntry.description);
            viewHolder.functionEntry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), functionEntry.cls);
                    getActivity().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            Log.i("test", "" + mCategory.entries.size());
            return mCategory.entries.size();
        }
    }

    public static class FunctionEntryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.function_entry)
        LinearLayout functionEntry;

        @BindView(R.id.tv_function_cover)
        ImageView tvFuntionCover;

        @BindView(R.id.tv_function_title)
        TextView tvFuntionTitle;

        @BindView(R.id.tv_function_description)
        TextView tvFuntionDescription;

        public FunctionEntryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
