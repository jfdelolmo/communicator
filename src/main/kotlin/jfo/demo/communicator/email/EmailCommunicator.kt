package jfo.demo.communicator.email

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import jfo.demo.communicator.CommunicatorError
import jfo.demo.communicator.CommunicatorSuccess
import jfo.demo.communicator.Communicator
import jfo.demo.communicator.DataInfo

data class EmailInfo(
    val address: String,
    val content: String
) : DataInfo()

fun EmailInfo.missingRequired() : Boolean = listOf(this.address, this.content).none { it.isNotEmpty() }

class EmailCommunicator(private val email: EmailInfo) : Communicator() {
    override fun execute() : Either<CommunicatorError, CommunicatorSuccess> {
        if (email.missingRequired()){
            return CommunicatorError.left()
        }
        println("Email communicator sending to ${email.address} - ${email.content}")
        return CommunicatorSuccess.right()
    }
}