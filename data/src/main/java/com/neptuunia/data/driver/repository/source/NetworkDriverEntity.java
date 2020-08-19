package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.source.network.DriverApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version NetworkDriverEntity, v 0.0.1 17/08/20 21.51 by Putra Nugraha
 */
public class NetworkDriverEntity implements DriverEntity {

    private DriverApi driverApi;

    @Inject
    public NetworkDriverEntity(Retrofit retrofit) {
        this.driverApi = retrofit.create(DriverApi.class);
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers() {
        // TODO (Putra): 17/08/20 Get History Drivers
        throw new UnsupportedOperationException("Will support later");
    }

    @Override
    public Single<Boolean> loginDriver(String email, String password) {
        return driverApi.loginDriver(email, password);
    }
}