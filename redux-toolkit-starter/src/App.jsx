import { useDispatch, useSelector } from 'react-redux'
import './App.css'
import { decrement, increment, reset } from '../redux/features/counter/counterSlice';

function App() {
  const count = useSelector(state => state.counter.value)
  const dispatch = useDispatch(); // fixed typo

  const handleIncrement = () => {
    console.log("handleIncrement clicked")
    dispatch(increment()) // fixed typo
  }

  const handleDecrement = () => {
    console.log("handleDecrement clicked")
    dispatch(decrement()) // fixed typo
  }

  const resetHandler = () => {
    console.log("resetHandler clicked")
    dispatch(reset()) // fixed typo
  }
  return (
    <>
      <div>Hello World</div>
      <div>
        <button onClick={handleIncrement}>+</button>
        <p>Count: {count}</p>
        <button onClick={handleDecrement}>-</button>
        <p></p>
        <button onClick={resetHandler}>Reset</button>
      </div>
    </>
  )
}

export default App


