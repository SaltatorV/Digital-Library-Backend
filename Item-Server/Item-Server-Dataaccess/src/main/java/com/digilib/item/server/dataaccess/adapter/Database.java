package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Database {
    public Set<ItemSnapshot> snapshots;

    public Database() {
        this.snapshots = new HashSet<>();
    }
}
