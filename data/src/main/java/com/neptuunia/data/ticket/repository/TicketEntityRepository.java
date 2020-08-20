package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.data.ticket.repository.source.TicketEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class TicketEntityRepository implements TicketRepository {

    private TicketEntityFactory ticketEntityFactory;

    @Inject
    public TicketEntityRepository(TicketEntityFactory ticketEntityFactory) {
        this.ticketEntityFactory = ticketEntityFactory;
    }

    @Override
    public Single<List<TicketResponse>> getTickets() {
        return createNetworkTicketEntity().getTickets();
    }

    public TicketEntity createNetworkTicketEntity() {
        return ticketEntityFactory.createTicketEntity(Source.NETWORK);
    }
}
