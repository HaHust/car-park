package com.h2s.carpark.sercurity;

import com.h2s.carpark.entity.Employee;
import com.h2s.carpark.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByAccount(account);
        if(employee==null){
            throw new UsernameNotFoundException("can't find account the following name");
        }
        return new CustomUserDetails(employee.getAccount(),employee.getPassword());
    }

}
