package es.iessaladillo.pedrojoya.tipcalculator.model


// TipCalculator class. Its constructor receives bill, percentage and diners

class TipCalculator(bill: Float, percentage: Float, diners: Int){

    val bill: Float
    val percentage: Float
    val diners: Int

    init {
        this.bill = bill
        this.percentage = percentage
        this.diners = diners
    }


    fun calculateTip(): Float {
        return (bill*percentage)/100
    }

    fun calculateTotal(): Float {
        return bill + calculateTip()
    }

    fun calculatePerDiner(): Float {
        return calculateTotal() / diners
    }

    fun calculatePerDinerRounded(): Float {
        return calculatePerDiner()
    }

}