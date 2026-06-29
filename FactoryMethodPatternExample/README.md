# Factory Method Design Pattern Example

This project demonstrates the **Factory Method Design Pattern** implemented in Java. The Factory Method pattern defines an interface for creating an object but lets subclasses decide which class to instantiate.

In this example, we model a **Document Management System** that creates different types of documents (`Word`, `PDF`, `Excel`) dynamically using specialized document factories.

## Project Structure

```text
FactoryMethodPatternExample/
│
├── README.md                           # Documentation for the project
└── src/
    └── com/
        └── patterns/
            └── factory/
                ├── Document.java       # Product Interface
                ├── WordDocument.java   # Concrete Product (Word)
                ├── PdfDocument.java    # Concrete Product (PDF)
                ├── ExcelDocument.java  # Concrete Product (Excel)
                ├── DocumentFactory.java # Abstract Creator
                ├── WordDocumentFactory.java # Concrete Creator (Word)
                ├── PdfDocumentFactory.java # Concrete Creator (PDF)
                ├── ExcelDocumentFactory.java # Concrete Creator (Excel)
                └── FactoryMethodPatternTest.java # Test suite to verify factory method
```

## Implementation Details

1. **Product Interface (`Document.java`)**: Declares the standard behaviors for all document products (`open()`, `save()`, `close()`).
2. **Concrete Products (`WordDocument`, `PdfDocument`, `ExcelDocument`)**: Implement the document interface with behavior specific to their file format.
3. **Abstract Creator (`DocumentFactory.java`)**: Declares the abstract `createDocument()` factory method, and implements helper logic (`processDocument()`) that relies on the product returned by subclasses.
4. **Concrete Creators (`WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory`)**: Subclass the `DocumentFactory` and override the factory method to return instances of the corresponding concrete products.

## How to Compile and Run

To compile and run this project, make sure you have the Java Development Kit (JDK) installed and configured on your system.

### Running via Terminal (from the project root directory)

1. **Navigate to the project root directory**:
   ```bash
   cd FactoryMethodPatternExample
   ```

2. **Compile the Java files**:
   ```bash
   javac -d bin src/com/patterns/factory/*.java
   ```
   *(This compiles all source files and outputs class files into a `bin` directory)*

3. **Run the test program**:
   ```bash
   java -cp bin com.patterns.factory.FactoryMethodPatternTest
   ```

### Expected Output
```text
=== Starting Factory Method Pattern Verification ===

Client: Requesting a Word document via WordDocumentFactory.
--- Processing Document ---
Opening Word document (.docx)...
Saving Word document to disk...
Closing Word document.
--- Process Completed ---

Client: Requesting a PDF document via PdfDocumentFactory.
--- Processing Document ---
Opening PDF document (.pdf) in reader mode...
Exporting PDF document...
Closing PDF document.
--- Process Completed ---

Client: Requesting an Excel document via ExcelDocumentFactory.
--- Processing Document ---
Opening Excel spreadsheet (.xlsx)...
Calculating formulas and saving Excel spreadsheet...
Closing Excel spreadsheet.
--- Process Completed ---

Client: Direct creation of documents:
Created document type: ExcelDocument
```
