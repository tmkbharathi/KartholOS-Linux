cmake_minimum_required(VERSION 3.16)

project(kartholos-shell VERSION 0.1 LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(Qt6 REQUIRED COMPONENTS Gui Qml Quick)

qt_add_executable(kartholos_shell
    main.cpp
)

qt_add_qml_module(kartholos_shell
    URI kartholos
    VERSION 1.0
    QML_FILES main.qml
)

target_link_libraries(kartholos_shell PRIVATE
    Qt6::Gui
    Qt6::Qml
    Qt6::Quick
)

install(TARGETS kartholos_shell
    BUNDLE DESTINATION .
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
