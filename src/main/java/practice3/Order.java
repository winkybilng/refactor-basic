package practice3;

import java.math.BigDecimal;
import java.util.List;

//public class Order {
//
//    private List<OrderLineItem> orderLineItemList;
//    private List<BigDecimal> discounts;
//    private BigDecimal tax;
//
//    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
//        this.orderLineItemList = orderLineItemList;
//        this.discounts = discounts;
//        this.tax = new BigDecimal(0.1);
//    }
//
//    public BigDecimal calculate() {
//        BigDecimal subTotal = new BigDecimal(0);
//
//        // Total up line items
//        for (OrderLineItem lineItem : orderLineItemList) {
//            subTotal = subTotal.add(lineItem.getPrice());
//        }
//
//        // Subtract discounts
//        for (BigDecimal discount : discounts) {
//            subTotal = subTotal.subtract(discount);
//        }
//
//        // calculate tax
//        BigDecimal tax = subTotal.multiply(this.tax);
//
//        // calculate GrandTotal
//        BigDecimal grandTotal = subTotal.add(tax);
//
//        return grandTotal;
//    }
//}

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;
    private BigDecimal grandTotal;



    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public BigDecimal calculate() {
        grandTotal = new BigDecimal(0);
        calculateSubTotal(orderLineItemList);
        calculateSubDiscounts(discounts);
        calculateAddTex();

        return grandTotal;
    }

    private void calculateSubTotal(List<OrderLineItem> orderLineItemList) {
        for (OrderLineItem lineItem : orderLineItemList) {
            grandTotal = grandTotal.add(lineItem.getPrice());
        }
    }

    private void calculateSubDiscounts(List<BigDecimal> discounts){
        for (BigDecimal discount : discounts) {
            grandTotal = grandTotal.subtract(discount);
        }
    }

    private void calculateAddTex(){

        grandTotal = grandTotal.add(grandTotal.multiply(this.tax));

    }


}
