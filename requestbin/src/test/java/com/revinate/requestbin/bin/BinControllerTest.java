package com.revinate.requestbin.bin;

import com.revinate.requestbin.bin.model.Bin;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinControllerTest {

    @Autowired
    private BinController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test(expected = NotImplementedException.class)
    public void getAllBin() throws Exception {
        create();
        create();

        mockMvc.perform(get("/bin"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test(expected = NotImplementedException.class)
    public void createBin() throws Exception {
        mockMvc.perform(post("/bin"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", not(isEmptyOrNullString())));
    }


    @Test(expected = NotImplementedException.class)
    public void inspectBin() throws Exception {
        Bin bin = controller.create();
        mockMvc.perform(get("/bin/" + bin.getId())).andExpect(status().isOk());
        mockMvc.perform(head("/bin/" + bin.getId())).andExpect(status().isOk());
        mockMvc.perform(options("/bin/" + bin.getId())).andExpect(status().isOk());
        mockMvc.perform(put("/bin/" + bin.getId())).andExpect(status().isOk());
        mockMvc.perform(patch("/bin/" + bin.getId())).andExpect(status().isOk());
        mockMvc.perform(post("/bin/" + bin.getId())).andExpect(status().isOk());
        mockMvc.perform(delete("/bin/" + bin.getId())).andExpect(status().isOk());
        mockMvc.perform(get("/bin/" + bin.getId() + "/inspect"))
            .andExpect(jsonPath("$.requests", hasSize(7)));
    }

    private void create() {
        // create a bin using mockMvc
    }

}
