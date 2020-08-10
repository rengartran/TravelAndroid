package com.neptuunia.travel.orderdetaildriver;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.constant.Variable;
import com.neptuunia.travel.databinding.ActivityOrderDetailDriverBinding;

import android.os.Bundle;
import android.view.View;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderDetailDriverActivity, v 0.0.1 04/08/20 07.39 by Putra Nugraha
 */
public class OrderDetailDriverActivity extends BaseActivity {

    private ActivityOrderDetailDriverBinding binding;

    @Override
    public View getView() {
        binding =
            ActivityOrderDetailDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            setupForm(bundle);
        }
    }

    private void setupForm(Bundle bundle) {
        HistoryDriverResponse historyDriverResponse =
            bundle.getParcelable(Variable.HISTORY_DRIVER_RESPONSE_DATA);

        if (historyDriverResponse != null) {
            binding.acetOrderCode.setText(String.valueOf(historyDriverResponse.getOrderCode()));
            binding.acetUserName.setText(historyDriverResponse.getUserName());
            binding.acetTicketAmount.setText(historyDriverResponse.getSeatBooked());
            binding.acetTotalPrice.setText(String.valueOf(historyDriverResponse.getPrice()));
            binding.acetNote.setText(historyDriverResponse.getNote());
            binding.acetLocation.setText(String.valueOf(historyDriverResponse.getOrderCode()));
        }
    }
}