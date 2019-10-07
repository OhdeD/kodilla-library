package com.kodilla.library.controller;

        import com.kodilla.library.domain.ReaderDto;
        import com.kodilla.library.domain.TitleDto;
        import com.kodilla.library.mapper.Mapper;
        import com.kodilla.library.service.DbService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {
    @Autowired
    DbService service;
    @Autowired
    Mapper mapper;

    @RequestMapping(method = RequestMethod.POST ,value = "newReader", consumes = "application/json")
    public void newReader(@RequestBody ReaderDto readerDto){
        service.addReader(mapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "newTitle", consumes = "application/json")
    public void newTitle(@RequestBody TitleDto titleDto){
        service.addTitle(mapper.mapToTitle(titleDto));
    }





}
