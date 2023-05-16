# functional-structural-plant-model

## Basic Guidelines for Writing Tests
- This is by no means an exhaustive or comprehensive guide. Please feel free to add more to this.

### Unit Tests
- The result of any test should not impact the result of other tests.

### Module Tests
- Tests should correspond to each module in the system
- A test for any module should be isolated from others modules and the result of their tests.
    - i.e. A module should be tested without the need to use other module. Consider using stubs and mocks.

### Integration Tests
- Modules under test should be clearly specified.
- Write to test modules that meet along interfaces, rather than across multiple modules.

## Displaying Test Results
- Refer to the [reportResult method in TestRunner](/src/fspm/testing/TestRunner.java#reportResult) to see the implementation for outputting failures and execution summary to GroIMP console.
- Refer to [ExecutionListener](/src/fspm/testing/ExecutionListener.java) for an example of extending JUnit RunListeners to output to GroIMP console.