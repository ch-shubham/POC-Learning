import { describe, it, expect } from 'vitest';
import counterReducer, { increment, decrement, reset } from './counterSlice';

describe('counterSlice', () => {
	it('should return the initial state', () => {
		expect(counterReducer(undefined, {})).toEqual({ value: 0 });
	});

	it('should handle increment', () => {
		expect(counterReducer({ value: 0 }, increment())).toEqual({ value: 1 });
	});

	it('should handle decrement', () => {
		expect(counterReducer({ value: 1 }, decrement())).toEqual({ value: 0 });
	});

	it('should handle reset', () => {
		expect(counterReducer({ value: 5 }, reset())).toEqual({ value: 0 });
	});
});