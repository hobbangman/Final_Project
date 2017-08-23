package board.model.vo;

public class BoardPage implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int page;
	private int limit;
	
	public BoardPage() {
		super();
	}

	public BoardPage(int page, int limit) {
		super();
		this.page = page;
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "BoardPage [page=" + page + ", limit=" + limit + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
