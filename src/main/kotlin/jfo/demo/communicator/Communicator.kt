package jfo.demo.communicator

import arrow.core.Either
import java.util.function.BiFunction

open class DataInfo
object CommunicatorSuccess
object CommunicatorError

enum class CommunicatorChannel(val builderFunction: BiFunction<CommunicatorBuilderByChannel, DataInfo, Communicator>) {
    SMS(CommunicatorBuilderByChannel::smsCommunicatorBuilder),
    EMAIL(CommunicatorBuilderByChannel::emailCommunicatorBuilder)
}

abstract class Communicator {
    abstract fun execute() : Either<CommunicatorError, CommunicatorSuccess>
}
