package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "REST API for Item QUERies",
        description = "The purpose of this REST API is to serve QUERies for the items."
)
@RestController
@RequestMapping(path = "/items", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class ItemQueryController {

    private final ItemQueryFacade itemQueryFacade;

    @Operation(
            summary = "GET an ITEM",
            description = "This API endpoint get ITEM by ISBN."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP status NOT_FOUND"
            )
    })
    @GetMapping("{ISBN}")
    ItemResponse findItem(
            @Parameter(description = "Item ISBN", required = true)
            @PathVariable String ISBN) {
        return itemQueryFacade.findItem(ISBN);
    }

    @Operation(
            summary = "GET an ITEMs summary",
            description = "This API endpoint get ITEMs summary."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
    })
    @GetMapping
    public List<ItemSummaryResponse> findItemsSummary() {
        return itemQueryFacade.fetchItemsSummary();
    }
}
