package com.muneeshk.lumenjpademo.services;

import com.muneeshk.lumenjpademo.exceptions.RecordNotFoundException;
import com.muneeshk.lumenjpademo.models.Customer;
import com.muneeshk.lumenjpademo.repositories.CustomerRepository;
import com.muneeshk.lumenjpademo.viewmodels.CustomerCreateViewModel;
import com.muneeshk.lumenjpademo.viewmodels.CustomerUpdateViewModel;
import com.muneeshk.lumenjpademo.viewmodels.CustomerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerViewModel> getAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerViewModel getbyId(int id) {
        return toViewModel(getEntitybyId(id));
    }

    @Override
    public CustomerViewModel create(CustomerCreateViewModel viewModel) {
        Customer entity = toEntity(viewModel);
        return toViewModel(customerRepository.saveAndFlush(entity));
    }

    @Override
    public CustomerViewModel update(int id, CustomerUpdateViewModel viewModel) {
        Customer entity = getEntitybyId(id);
        BeanUtils.copyProperties(viewModel,entity);
        return toViewModel(customerRepository.saveAndFlush(entity));
    }

    @Override
    public void deletebyId(int id) {
        customerRepository.delete(getEntitybyId(id));

    }
    private CustomerViewModel toViewModel(Customer entity){
        CustomerViewModel viewModel = new CustomerViewModel();
        BeanUtils.copyProperties(entity,viewModel);///important
        return viewModel;
    }
    private Customer toEntity(CustomerCreateViewModel viewModel){
        Customer entity = new Customer();
        BeanUtils.copyProperties(entity,viewModel);
        return entity;
    }
    private Customer getEntitybyId(int id){
        return customerRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException
                        (String.format("Customer with ID : %d  is not found",id)
                        )
                );
    }
}
