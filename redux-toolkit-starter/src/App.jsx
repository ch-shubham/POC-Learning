import { useDispatch, useSelector } from 'react-redux'
import './App.css'
import { decrement, increment, reset } from '../redux/features/counter/counterSlice';

function App() {
  const count = useSelector(state => state.counter.value)
  const disptach = useDispatch();

  const handleIncrement = () => {
    console.log("handleIncrement clicked")
    disptach(increment())
  }

  const handleDecrement = () => {
    console.log("handleDecrement clicked")
    disptach(decrement())
  }

  const resetHandler = () => {
    console.log("resetHandler clicked")
    disptach(reset())
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
