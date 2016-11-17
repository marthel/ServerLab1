package DB.Entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Marthin on 2016-11-17.
 */
@Entity
@Table(name = "chat_message", schema = "lab1", catalog = "")
public class ChatMessageEntity {
    private int chatMessageId;
    private String message;
    private Date sendDate;
    private UserEntity userBySenderId;
    private UserEntity userByReceiverId;

    @Id
    @Column(name = "chat_message_id")
    public int getChatMessageId() {
        return chatMessageId;
    }

    public void setChatMessageId(int chatMessageId) {
        this.chatMessageId = chatMessageId;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "send_date")
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMessageEntity that = (ChatMessageEntity) o;

        if (chatMessageId != that.chatMessageId) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chatMessageId;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    public UserEntity getUserBySenderId() {
        return userBySenderId;
    }

    public void setUserBySenderId(UserEntity userBySenderId) {
        this.userBySenderId = userBySenderId;
    }

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "user_id")
    public UserEntity getUserByReceiverId() {
        return userByReceiverId;
    }

    public void setUserByReceiverId(UserEntity userByReceiverId) {
        this.userByReceiverId = userByReceiverId;
    }
}
