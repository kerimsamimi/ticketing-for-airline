package com.kerimsamimi.ticketingforairline.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity {
    @Id
    @Column(name = "PAYMENT_ID")
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2", parameters = { @org.hibernate.annotations.Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
    private String id;

    @Column(name = "CARD_NO")
    private String cardNo;

    @Column(name = "EXPIRATION_DATE")
    private String expirationDate;

    @Column(name = "CVC_CODE")
    private Integer cvcCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET")
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
