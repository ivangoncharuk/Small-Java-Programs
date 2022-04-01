package cosc237.lab11;


public class QueueOverflowException extends QueueException
{
    public QueueOverflowException()
    {
        super("Queue Overflow");
    }

    public QueueOverflowException(String msg)
    {
        super(msg);
    }
}

