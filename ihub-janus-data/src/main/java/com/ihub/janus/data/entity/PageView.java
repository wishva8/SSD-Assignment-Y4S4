package com.ihub.janus.data.entity;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonView;
import com.ihub.janus.data.view.Views;

public class PageView implements Page {

	@Override
	@JsonView(Views.PageView.class)
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@JsonView(Views.PageView.class)
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@JsonView(Views.PageView.class)
	public int getNumberOfElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@JsonView(Views.PageView.class)
	public List getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@JsonView(Views.PageView.class)
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pageable nextPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@JsonView(Views.PageView.class)
	public int getTotalPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@JsonView(Views.PageView.class)
	public long getTotalElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page map(Function converter) {
		// TODO Auto-generated method stub
		return null;
	}

}
