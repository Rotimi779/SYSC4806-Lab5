package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressBookViewController {

    private final AddressBookRepository addressBookRepository;

    public AddressBookViewController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/view/addressbooks/{id}")
    public String viewAddressBook(@PathVariable int id, Model model) {

        AddressBook addressBook = addressBookRepository
                .findById(id)
                .orElseThrow();

        model.addAttribute("addressBook", addressBook);

        return "addressbook";
    }
}
