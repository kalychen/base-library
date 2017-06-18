package com.devinchen.library.common.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.devinchen.library.common.base.holder.BaseHolder;

import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.adapter
 * Created by Devin Chen on 2017/5/25 11:22.
 * explain:两重ListView的Adapter
 * 由于内部数据集合的不确定，所以需要验证
 */

public abstract class BaseExpandableAdapter<GroupModel, ChildModel, GroupHolder extends BaseHolder, ChildHolder extends BaseHolder> extends BaseExpandableListAdapter {
    public Context context;
    public List<GroupModel> groupDataList;

    public BaseExpandableAdapter(Context context) {
        this.context = context;
    }

    public BaseExpandableAdapter(Context context, List<GroupModel> groupDataList) {
        this.context = context;
        this.groupDataList = groupDataList;
    }

    @Override
    public int getGroupCount() {
        return groupDataList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return getChildDataList(groupPosition).size();
    }


    @Override
    public GroupModel getGroup(int groupPosition) {
        GroupModel groupModel = groupDataList.get(groupPosition);

        return groupModel;
    }

    /**
     * 获得子数据集合
     *
     * @param groupModel
     * @return
     */
    protected abstract List<ChildModel> getChildDataList(GroupModel groupModel);

    @Override
    public ChildModel getChild(int groupPosition, int childPosition) {
        return getChildData(groupPosition, childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(groupLayoutId(), parent, false);
            holder = createGroupHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupHolder) convertView.getTag();
        }
        bindGroupHolder(holder, groupPosition, isExpanded);
        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(childLayoutId(), parent, false);
            holder = createChildHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildHolder) convertView.getTag();
        }
        bindChildHolder(holder, groupPosition, childPosition, isLastChild);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    /**
     * 更新数据
     *
     * @param groupDataList
     */
    public void updateData(List<GroupModel> groupDataList) {
        this.groupDataList = groupDataList;
        notifyDataSetChanged();
    }

    /**
     * 获得子数据列表
     *
     * @param groupPosition
     * @return
     */
    protected abstract List<ChildModel> getChildDataList(int groupPosition);

    /**
     * 获得子数据
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    protected abstract ChildModel getChildData(int groupPosition, int childPosition);

    /**
     * 分组列表项布局
     *
     * @return
     */
    protected abstract
    @LayoutRes
    int groupLayoutId();

    /**
     * 子列表项布局
     *
     * @return
     */
    protected abstract
    @LayoutRes
    int childLayoutId();

    /**
     * 创建分组列表项的holder
     *
     * @param convertView
     * @return
     */
    protected abstract GroupHolder createGroupHolder(View convertView);

    /**
     * 创建子列表项的holder
     *
     * @param convertView
     * @return
     */
    protected abstract ChildHolder createChildHolder(View convertView);

    /**
     * 为分组项空间添加数据
     *
     * @param holder
     * @param groupPosition
     * @param isExpanded
     */
    protected abstract void bindGroupHolder(GroupHolder holder, int groupPosition, boolean isExpanded);

    /**
     * 为子列表控件添加数据
     *
     * @param holder
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     */
    protected abstract void bindChildHolder(ChildHolder holder, int groupPosition, int childPosition, boolean isLastChild);

}
