#pragma once

#include "App.xaml.g.h"

namespace winrt::TextEditor::implementation
{
    struct App : AppT<App>
    {
        App() noexcept;
    };
} // namespace winrt::TextEditor::implementation


