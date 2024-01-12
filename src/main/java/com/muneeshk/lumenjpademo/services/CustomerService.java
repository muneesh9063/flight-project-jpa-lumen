package com.muneeshk.lumenjpademo.services;

import com.muneeshk.lumenjpademo.viewmodels.CustomerCreateViewModel;
import com.muneeshk.lumenjpademo.viewmodels.CustomerUpdateViewModel;
import com.muneeshk.lumenjpademo.viewmodels.CustomerViewModel;

import java.util.List;

public interface CustomerService {
    List<CustomerViewModel> getAll();
    CustomerViewModel getbyId(int id);
    CustomerViewModel create(CustomerCreateViewModel viewModel);
    CustomerViewModel update(int id, CustomerUpdateViewModel viewModel);
    void deletebyId(int id);
}
