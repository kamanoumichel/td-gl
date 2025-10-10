import java.time.LocalDateTime;


public class RequestForm {

	private String id;
	private RequestType type;
	private LocalDateTime fillDate;
	private String content;
	private Patient filedBy;

	public RequestForm() {}

	public RequestForm(String id, RequestType type, String content, Patient filledBy) {
		this.id = id; this.type = type; this.content = content; this.filedBy = filledBy;
	}
}