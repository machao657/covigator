package com.almondach.machao.covigator.Options.DirectorySelector;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.almondach.machao.covigator.R;

public class DirPickerFragment extends Fragment implements AbsListView.OnItemClickListener,View.OnClickListener{

    private OnItemClickListener mListener;

    private AbsListView mListView;

    private ListAdapter mAdapter;

    private Button okButton;

    private Adapter anotheradpater;

    public DirPickerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = NewAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dirpicker, container, false);
        prepareViews(view);

        return view;
    }

    private void prepareViews(View view){
        mListView = (AbsListView) view.findViewById(R.id.dir_picker_list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

        okButton = (Button)view.findViewById(R.id.dir_picker_ok_button);
        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        mListener.OnOkButtonClicked();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnItemClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            mListener.OnItemClicked(position);
        }
    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public interface OnItemClickListener {
        public void OnItemClicked(int position);
        public void OnOkButtonClicked();
    }

    public void RefreshView(){
        mListView.setAdapter(NewAdapter());

    }

    private ArrayAdapter<DirContent.FileDirPath> NewAdapter(){
        //got to get a new adapter to update list contents everytime
        return  new ArrayAdapter<DirContent.FileDirPath>(getActivity(),
                R.layout.dir_item, R.id.dir_item_text, SelectDirActivity.dirContent.dirs);
    }

}
