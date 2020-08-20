package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.account.model.Account;
import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.model.LoginDriverRequest;
import com.neptuunia.data.driver.model.LoginDriverResponse;
import com.neptuunia.data.driver.model.ProfileDriverResponse;

import java.util .ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class MockDriverEntity implements DriverEntity {

    @Inject
    public MockDriverEntity() {
        // For dagger injection
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers() {
        List<HistoryDriverResponse> armadaSettingResponses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            HistoryDriverResponse armadaSettingResponse = new HistoryDriverResponse();
            armadaSettingResponse.setOrderCode(i);
            armadaSettingResponse.setGroup(String.format("Group: %s", i));
            armadaSettingResponse.setArmadaClass(String.format("Armada Class: %s", i));
            armadaSettingResponse.setUserName(String.format("User Name: %s", i));
            armadaSettingResponse.setLatitude(i);
            armadaSettingResponse.setLongitude(i);
            armadaSettingResponse.setNote(String.format("Code: %s", i));
            armadaSettingResponse.setPrice(i);
            armadaSettingResponse.setSeatBooked(String.format("Seat number: %s", i));

            armadaSettingResponses.add(armadaSettingResponse);
        }

        return Single.just(armadaSettingResponses);
    }

    @Override
    public Single<ProfileDriverResponse> getProfileDriver(Account account) {
        return Single.just(new ProfileDriverResponse());
    }

    @Override
    public Single<LoginDriverResponse> loginDriver(LoginDriverRequest loginDriverRequest) {
        return Single.just(new LoginDriverResponse());
    }
}
