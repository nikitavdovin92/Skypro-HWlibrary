package com.example.skyprohw25.service;


import com.example.skyprohw25.exception.IncorrectFirstnameException;
import com.example.skyprohw25.exception.IncorrectLastnameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class ValidatorService {
    public String validateFirstname (String firstName) {
        if (StringUtils.isAlpha(firstName)) {
            throw new IncorrectFirstnameException();
        }
        return StringUtils.capitalize(firstName.toLowerCase());
    }

    public String validateLastName (String lastName) {
        String[] lastNames = lastName.split("-");
        for (int i = 0; i < lastNames.length; i++) {
            if (!StringUtils.isAlpha(lastNames[i])) {
                throw new IncorrectLastnameException();
            }
            lastNames [i] = StringUtils.capitalize(lastNames[i].toLowerCase());
        }
        return String.join("-", lastNames);
    }
}
