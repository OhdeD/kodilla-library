package com.kodilla.library.controller;

        import com.kodilla.library.domain.*;
        import com.kodilla.library.mapper.Mapper;
        import com.kodilla.library.service.DbService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {
    @Autowired
    DbService service;
    @Autowired
    Mapper mapper;

    @RequestMapping(method = RequestMethod.POST ,value = "newReader", consumes = "application/json")
    public void addReader(@RequestBody ReaderDto readerDto){
        service.addReader(mapper.mapToReaderBasic(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "newTitle", consumes = "application/json")
    public void addTitle(@RequestBody TitleDto titleDto){
        service.addTitle(mapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "newSpecimen", consumes = "application/json")
    public void addSpecimen(@RequestBody SpecimenDto specimenDto){
        service.addSpecimen(mapper.mapToSpecimens(specimenDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "newStatus")
    public SpecimenDto changeStatus(@RequestBody SpecimenDto specimenDto){
       return mapper.mapToSpecimensDto(service.addSpecimen(mapper.mapToSpecimens(specimenDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "availableSpecimens")
    public List<SpecimenDto> getAvailableSpecimens(@RequestParam Long titleId){
        return mapper.mapToSpecimensDtoList(service.getAvailableSpecimensOfOneTitle(titleId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "borrow", consumes = "application/json")
    public void borrowTitle(@RequestBody BorrowingsDto borrowingsDto) {
        service.saveBorrowing(mapper.mapToBorrowings(borrowingsDto));

    }

    @RequestMapping(method = RequestMethod.PUT, value = "return")
    public void returnTitle(@RequestParam Long readerId, @RequestParam Long specimenId){
        service.returnTitle(readerId,specimenId);
    }

}
