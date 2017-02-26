package mindbadger.football.repository;

public class RepositoryException extends RuntimeException {
	private static final long serialVersionUID = 4818154351253610833L;

	public RepositoryException() {
		super();
	}

	public RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}
	
}
