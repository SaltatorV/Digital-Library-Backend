package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.command.UpdateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "REST API for Item COMMANDs",
        description = "The purpose of this REST API is to serve COMMANDs for the items."
)
@RestController
@RequestMapping(path = "/items", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class ItemCommandController {
    private final ItemCommandFacade itemCommandFacade;

    @Operation(
            summary = "ADD new ITEM",
            description = "This API endpoint adds new item to the system."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP status CREATED"
            ),
            @ApiResponse(
                responseCode = "400",
                description = "HTTP status BAD_REQUEST"
            )
    })
    @PostMapping
    public MessageResponse saveItem(@RequestBody CreateItemCommand command) {
        return itemCommandFacade.createItem(command);
    }

    @Operation(
            summary = "DELETE an ITEM",
            description = "This API endpoint delete item from the system."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP status BAD_REQUEST"
            )
    })
    @DeleteMapping("{ISBN}")
    public MessageResponse deleteItem(@PathVariable String ISBN) {
        return itemCommandFacade.deleteItem(ISBN);
    }

    @Operation(
            summary = "UPDATE an ITEM",
            description = "This API endpoint update specific item."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP status BAD_REQUEST"
            )
    })
    @PatchMapping("{ISBN}")
    public MessageResponse updateItem(@PathVariable String ISBN, @RequestBody UpdateItemCommand command) {
        return itemCommandFacade.updateItem(ISBN, command);
    }

    @Operation(
            summary = "ADD ITEM_DETAILS",
            description = "This API endpoint bound item details with an item."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP status BAD_REQUEST"
            )
    })
    @PostMapping("{ISBN}/details")
    public MessageResponse createItemDetails(@PathVariable String ISBN, @RequestBody CreateItemDetailsCommand command) {
        return itemCommandFacade.createItemDetails(ISBN, command);
    }
}
