package stateMashine

import java.lang.UnsupportedOperationException

enum class STATES : State {
    CREATED {
        override fun approve(order: Order) {
            println("order ${order.id} is approved")
            order.state = IN_PROGRESS
        }

        override fun cancel(order: Order) {
            println("order ${order.id} is canceled")
            order.state = CANCELED
        }
    },
    IN_PROGRESS {
        override fun approve(order: Order) {
            throw UnsupportedOperationException()
        }

        override fun cancel(order: Order) {
            println("order ${order.id} is canceled")
            order.state = CANCELED
        }

    },
    DONE {
        override fun approve(order: Order) {
            throw UnsupportedOperationException()
        }

        override fun cancel(order: Order) {
            throw UnsupportedOperationException()
        }
    },
    CANCELED {
        override fun approve(order: Order) {
            throw UnsupportedOperationException()
        }

        override fun cancel(order: Order) {
            throw UnsupportedOperationException()
        }
    };
}

interface State {
    fun approve(order: Order)
    fun cancel(order: Order)
}

class Order(
    var id: Int,
    var name: String,
    var state: State
) {

    fun makeApproved() {
        state.approve(this)
    }

    fun cancel() {
        state.cancel(this)
    }
}


fun main() {
    val newOrder = Order(1, "Pen", STATES.CREATED)
    newOrder.makeApproved()
    newOrder.cancel()
    println(newOrder.state)
}
