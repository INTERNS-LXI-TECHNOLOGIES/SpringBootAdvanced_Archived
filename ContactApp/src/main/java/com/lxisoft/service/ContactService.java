package com.lxisoft.service;
import com.lxisoft.domain.*;
import java.util.*;
import com.lxisoft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	@Autowired
	DbRepository repo;
	ArrayList<Contact> contactList=repo.findAll();
}
