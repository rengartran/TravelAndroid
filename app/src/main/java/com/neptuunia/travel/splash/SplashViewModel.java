package com.neptuunia.travel.splash;

import com.neptuunia.data.account.model.Account;
import com.neptuunia.data.account.repository.AccountRepository;
import com.neptuunia.data.constant.AccountType;
import com.neptuunia.travel.BuildConfig;

import android.app.Application;
import android.text.TextUtils;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version MainViewModel, v 0.0.1 19/08/20 12.05 by Putra Nugraha
 */
public class SplashViewModel extends AndroidViewModel {

    private MutableLiveData<String> homeDriverLiveData = new MutableLiveData<>();

    private MutableLiveData<String> homeUserLiveData = new MutableLiveData<>();

    private MutableLiveData<String> loginDriverLiveData = new MutableLiveData<>();

    private MutableLiveData<String> loginUserLiveData = new MutableLiveData<>();

    private AccountRepository accountRepository;

    @Inject
    public SplashViewModel(
        @NonNull Application application,
        AccountRepository accountRepository
    ) {
        super(application);
        this.accountRepository = accountRepository;
    }

    public MutableLiveData<String> getHomeDriverLiveData() {
        return homeDriverLiveData;
    }

    public MutableLiveData<String> getHomeUserLiveData() {
        return homeUserLiveData;
    }

    public MutableLiveData<String> getLoginDriverLiveData() {
        return loginDriverLiveData;
    }

    public MutableLiveData<String> getLoginUserLiveData() {
        return loginUserLiveData;
    }

    public void checkSession() {
        Account account = accountRepository.getSession();
        if (account.getId() > 0 && !TextUtils.isEmpty(account.getType())) {
            postHomeLiveData(account.getType());
        } else {
            postLoginLiveData(BuildConfig.FLAVOR);
        }
    }

    private void postHomeLiveData(@AccountType String accountType) {
        if (AccountType.DRIVER.equalsIgnoreCase(accountType)) {
            homeDriverLiveData.postValue(accountType);
        } else {
            homeUserLiveData.postValue(accountType);
        }
    }

    private void postLoginLiveData(String accountType) {
        if (AccountType.DRIVER.equalsIgnoreCase(accountType)) {
            loginDriverLiveData.postValue(accountType);
        } else {
            loginUserLiveData.postValue(accountType);
        }
    }
}
