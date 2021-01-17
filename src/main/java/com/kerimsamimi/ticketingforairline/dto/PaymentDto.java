package com.kerimsamimi.ticketingforairline.dto;

public class PaymentDto extends BaseDto {
    private String id;
    private String cardNo;
    private String expirationDate;
    private Integer cvcCode;
    private CustomerDto customer;
    private TicketDto ticket;

    public TicketDto getTicket() {
        return ticket;
    }

    public void setTicket(TicketDto ticket) {
        this.ticket = ticket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(Integer cvcCode) {
        this.cvcCode = cvcCode;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
