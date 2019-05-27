package com.coroutine.bod.optimiza;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class ImplAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ImplAdapter() {
        super(R.layout.item_test);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tvInfo, item);
        helper.setRating(R.id.ratBar, 3.0f);
    }
}
