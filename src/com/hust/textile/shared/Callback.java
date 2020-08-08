package com.hust.textile.shared;

public abstract interface Callback<T> {
	public abstract void onCallback(T object);
}
