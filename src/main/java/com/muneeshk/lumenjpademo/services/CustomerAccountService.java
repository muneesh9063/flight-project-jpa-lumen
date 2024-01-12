package com.muneeshk.lumenjpademo.services;
import com.muneeshk.lumenjpademo.viewmodels.*;
import java.util.List;

public interface CustomerAccountService {
    List<CustomerAccountViewModel> getAll();
    CustomerAccountViewModel getById(int id);
    List<CustomerAccountViewModel> getByCustomerId(int customerId);
    CustomerAccountViewModel create(CustomerAccountCreateViewModel viewModel);
    void deleteById(int id);
}
