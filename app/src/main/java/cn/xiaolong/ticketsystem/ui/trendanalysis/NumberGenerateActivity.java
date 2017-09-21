package cn.xiaolong.ticketsystem.ui.trendanalysis;

import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;

import cn.xiaolong.ticketsystem.R;
import cn.xiaolong.ticketsystem.base.BaseTitleBar;
import cn.xiaolong.ticketsystem.base.BaseTitleBarActivity;
import cn.xiaolong.ticketsystem.bean.TicketRegular;
import cn.xiaolong.ticketsystem.utils.LaunchUtil;

/**
 * @author xiaolong
 * @version v1.0
 * @function <描述功能>
 * @date: 2017/9/19 17:29
 */

public class NumberGenerateActivity extends BaseTitleBarActivity {
    private AppCompatSpinner spGenerateCount;
    private TicketRegular mTicketRegular;

    public static Bundle buildBundle(TicketRegular ticketRegular) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ticketRegular", ticketRegular);
        return bundle;
    }

    @Override
    public void getExtra() {
        super.getExtra();
        mTicketRegular = (TicketRegular) getIntent().getSerializableExtra("ticketRegular");
    }

    @Override
    public void initTitleBar(BaseTitleBar titleBar) {
        titleBar.setTitleText("随机摇号");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_number_generate;
    }

    @Override
    protected void init() {
        spGenerateCount = findView(R.id.spGenerateCount);
        SpinnerAdapter spinnerAdapter = new ArrayAdapter(this, R.layout.item_spinner_array,
                new String[]{"1 注", "2 注", "5 注", "10 注", "20 注", "50 注"});
        spGenerateCount.setAdapter(spinnerAdapter);
    }

    @Override
    protected void setListener() {
        ClickView(findView(R.id.llNumberBase))
                .subscribe(o -> LaunchUtil.launchActivity(this, NumberBaseSelectActivity.class,
                        NumberBaseSelectActivity.buildBundle(mTicketRegular)));
    }
}