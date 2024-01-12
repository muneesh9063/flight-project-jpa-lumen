package com.muneeshk.lumenjpademo.apis;

import com.muneeshk.lumenjpademo.services.CustomerAccountService;
import com.muneeshk.lumenjpademo.viewmodels.CustomerAccountCreateViewModel;
import com.muneeshk.lumenjpademo.viewmodels.CustomerAccountViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/customer-accounts")
public class CustomerAccountApi {
    private final CustomerAccountService customerAccountService;

    public CustomerAccountApi(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerAccountViewModel>> getAll() {
        return ResponseEntity.ok(customerAccountService.getAll());
    }

    @GetMapping("by-customer/{customerId}")
    public ResponseEntity<List<CustomerAccountViewModel>> getAllByCustomerId(@PathVariable int customerId) {
        return ResponseEntity.ok(customerAccountService.getByCustomerId(customerId));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerAccountViewModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(customerAccountService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerAccountViewModel> create(@RequestBody CustomerAccountCreateViewModel viewModel) {
        return ResponseEntity.ok(customerAccountService.create(viewModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        customerAccountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}