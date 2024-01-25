package com.webapp.controller;


import com.webapp.Service.ItemsandPricesService;
import com.webapp.model.ItemsandPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemsandPricesController {

    @Autowired
    ItemsandPricesService itemsandPricesService;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public ModelAndView showHomePage(ModelMap model){
        ModelAndView mv = new ModelAndView();
        List<ItemsandPrices> ip = itemsandPricesService.getListofItemsandPrices();
        int totalPrice=ip.
                stream().
                mapToInt(prices-> prices.getPrice()).
                sum();
        model.addAttribute("total",totalPrice);
        model.addAttribute("allItems",ip);
        mv.setViewName("allItems");
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView showItemAddPage(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        ItemsandPrices ip = new ItemsandPrices();
        model.addAttribute("addItems",ip);
        mv.setViewName("addItemsForm");
        return mv;
    }
    @PostMapping("/new")
    public String addItem(@ModelAttribute("addItems") ItemsandPrices ip,ModelMap model){
        itemsandPricesService.saveItem(ip);
        List<ItemsandPrices> itemsandPricesList = itemsandPricesService.getListofItemsandPrices();
        int totalPrice=itemsandPricesList.
                stream().
                mapToInt(prices-> prices.getPrice()).
                sum();
        model.addAttribute("allItems", itemsandPricesList);
        model.addAttribute("total",totalPrice);
        return "allItems";
    }

    @GetMapping("/edit-{id}")
//	@RequestMapping(value = { "/edit-{id}" }, method = RequestMethod.GET)
    public String editStudent(@PathVariable Long id, ModelMap model) {
        ItemsandPrices item = itemsandPricesService.getItemById(id);
        model.addAttribute("addItems",item);
        model.addAttribute("edit", true);
        return "addItemsForm";
    }

    @PostMapping("/edit-{id}")
    public ModelAndView updateStudent(@ModelAttribute("addItems") ItemsandPrices ip,@PathVariable Long id, ModelMap model){

            ModelAndView mv = new ModelAndView();
            itemsandPricesService.update(id, ip);
            List<ItemsandPrices> list = itemsandPricesService.getListofItemsandPrices();
            List<ItemsandPrices> itemsandPricesList = itemsandPricesService.getListofItemsandPrices();
            int totalPrice=itemsandPricesList.
                stream().
                mapToInt(prices-> prices.getPrice()).
                sum();
            model.addAttribute("allItems", list);
            model.addAttribute("total",totalPrice);
            mv.setViewName("allItems");

        return mv;
    }
    @GetMapping("/delete-{id}")
//	@RequestMapping(value = { "/delete-{id}" }, method = RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable Long id, ModelMap model) {
        ModelAndView mv = new ModelAndView();
        ItemsandPrices ip = itemsandPricesService.getItemById(id);
        itemsandPricesService.delete(id);
        List<ItemsandPrices> list = itemsandPricesService.getListofItemsandPrices();
        model.addAttribute("allItems", list);
        List<ItemsandPrices> itemsandPricesList = itemsandPricesService.getListofItemsandPrices();
        int totalPrice=itemsandPricesList.
                stream().
                mapToInt(prices-> prices.getPrice()).
                sum();
        mv.setViewName("allItems");
        model.addAttribute("total",totalPrice);
        return mv;
    }
}
